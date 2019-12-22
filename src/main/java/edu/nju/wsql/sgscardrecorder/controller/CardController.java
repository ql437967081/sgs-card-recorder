package edu.nju.wsql.sgscardrecorder.controller;

import edu.nju.wsql.sgscardrecorder.model.Card;
import edu.nju.wsql.sgscardrecorder.model.CardHeap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Api(tags = "卡牌操作")
@RestController
@RequestMapping("/card")
public class CardController {

    private static Map<Long, CardHeap> cardHeaps = Collections.synchronizedMap(new HashMap<>());

    private static AtomicLong cardHeapCnt = new AtomicLong(1);

    @PostMapping("/")
    @ApiOperation(value = "创建新牌堆")
    public Long newCardHeap() {
        long id = cardHeapCnt.getAndIncrement();
        cardHeaps.put(id, new CardHeap());
        return id;
    }

    @GetMapping("/{id}")
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "牌堆编号", required = true, example = "1")
    @ApiOperation(value = "获取牌堆详细信息", notes = "根据url的id来获取牌堆详细信息")
    public CardHeap getCardHeap(@PathVariable Long id) {
        return cardHeaps.get(id);
    }

    @PutMapping("/{id}/abandon")
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "牌堆编号", required = true, example = "1")
    @ApiOperation(value = "弃置卡牌", notes = "根据url的id来指定更新对象，并根据传过来的卡牌信息将其置入弃牌堆")
    public CardHeap abandonCard(@PathVariable Long id, @RequestBody Card card) {
        CardHeap cardHeap = cardHeaps.get(id);
        cardHeap.abandonCard(card);
        return cardHeap;
    }

    @PutMapping("/{id}/expose")
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "牌堆编号", required = true, example = "1")
    @ApiOperation(value = "明置卡牌", notes = "根据url的id来指定更新对象，并根据传过来的卡牌信息将其明置")
    public CardHeap exposeCard(@PathVariable Long id, @RequestBody Card card) {
        CardHeap cardHeap = cardHeaps.get(id);
        cardHeap.exposeCard(card);
        return cardHeap;
    }

    @PutMapping("/{id}/refresh")
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "牌堆编号", required = true, example = "1")
    @ApiOperation(value = "刷新牌堆", notes = "将弃牌堆的所有牌加入牌堆")
    public CardHeap refreshCard(@PathVariable Long id) {
        CardHeap cardHeap = cardHeaps.get(id);
        cardHeap.refreshCard();
        return cardHeap;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除牌堆", notes = "根据url的id来指定删除对象")
    public String deleteCardHeap(@PathVariable Long id) {
        cardHeaps.remove(id);
        return "success";
    }
}
