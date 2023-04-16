package com.juzi.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.handler.CustomGlobalBlockHandler;
import com.juzi.springcloud.handler.CustomGlobalFallbackHandler;
import com.juzi.springcloud.model.entity.Member;
import com.juzi.springcloud.service.MemberService;
import com.juzi.springcloud.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author codejuzi
 * @CreateTime 2023/4/13
 */
@Slf4j
@RestController
@RequestMapping("/member/provider")
public class MemberProviderController {

    @Resource
    private MemberService memberService;

    @PostMapping("/save")
    public BaseResponse<Long> saveMember(@RequestBody Member member) {
        Long memberId = memberService.saveMember(member);
        log.info("save member result: {}", memberId);
        return ResultUtil.success(memberId, "10004 ==> 新增");
    }

    @GetMapping("/get/{id}")
    public BaseResponse<Member> getMemberById(@PathVariable("id") Integer id) {
        Member member = memberService.getById(id);
        log.info("10004 ==> 查询结果：{}", member);
        return ResultUtil.success(member, "10004 ==> 查询");
    }

    // region test

    @GetMapping("/t1")
    public BaseResponse<String> t1() {
        return ResultUtil.success("====> t1()....");
    }

    @GetMapping("/t2")
    public BaseResponse<String> t2() {

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("===> current thread id: {}", Thread.currentThread().getId());

        return ResultUtil.success("====> t2()....");
    }

    @GetMapping("/t3")
    public BaseResponse<String> t3() {

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("===> current thread id: {}", Thread.currentThread().getId());

        return ResultUtil.success("====> t3()....");
    }

    @GetMapping("/news")
    @SentinelResource(value = "news", blockHandler = "newsBlockHandler")
    public BaseResponse<String> getNews(@RequestParam(value = "id", required = false) String id,
                                        @RequestParam(value = "type", required = false) String type) {
        log.info("query from db, id: {}, type: {}", id, type);
        return ResultUtil.success("id = " + id + "， news <====");
    }

    public BaseResponse<String> newsBlockHandler(String id, String type, BlockException blockException) {
        log.info("query from db failed, id: {}, type: {}, exception: {}", id, type, blockException);
        return ResultUtil.success("id = " + id + "， news ===> blocking<===");
    }

    private int num = 0;

    @GetMapping("/t4")
    @SentinelResource(
            value = "t4",
            blockHandlerClass = CustomGlobalBlockHandler.class,
            blockHandler = "blockHandler01",
            fallbackClass = CustomGlobalFallbackHandler.class,
            fallback = "fallbackHandler01",
            exceptionsToIgnore = {RuntimeException.class}
    )
    public BaseResponse<String> t4() {
        final int numException = 5;
        if (++num % numException == 0) {
            throw new RuntimeException("num值异常" + num);
        }
        log.info("===> current thread id: {}", Thread.currentThread().getId());

        return ResultUtil.success("====> t4()....");
    }

    // endregion

}
