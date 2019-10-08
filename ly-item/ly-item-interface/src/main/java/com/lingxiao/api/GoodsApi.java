package com.lingxiao.api;

import com.lingxiao.pojo.Sku;
import com.lingxiao.pojo.Spu;
import com.lingxiao.pojo.SpuDetail;
import com.lingxiao.vo.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
public interface GoodsApi {
    @GetMapping("/spu/detail/{id}")
    SpuDetail getGoodsDetail(@PathVariable("id") Long id);

    @GetMapping("/sku/list/{sPuId}")
    List<Sku> getSkusByPid(@PathVariable("sPuId") Long id);
    @GetMapping("/spu/page")
    PageResult<Spu> getGoodsByPage(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "saleable",required = false) Boolean saleable,
            @RequestParam(value = "key",required = false) String key
    );
}