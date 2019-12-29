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
@CrossOrigin(value = "http://localhost:8081", allowCredentials = "true")
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

    @PutMapping("/{id}/abandon_current")
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "牌堆编号", required = true, example = "1")
    @ApiOperation(value = "弃置暗置卡牌", notes = "根据url的id来指定更新对象，并根据传过来的卡牌信息将其置入弃牌堆")
    public String abandonCardFromCurrent(@PathVariable Long id, @RequestBody Card card) {
        CardHeap cardHeap = cardHeaps.get(id);
        cardHeap.abandonCardFromCurrentHeap(card);
        return "success";
    }

    @PutMapping("/{id}/abandon_exposed")
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "牌堆编号", required = true, example = "1")
    @ApiOperation(value = "弃置明置卡牌", notes = "根据url的id来指定更新对象，并根据传过来的卡牌信息将其置入弃牌堆")
    public String abandonCardFromExposed(@PathVariable Long id, @RequestBody Card card) {
        CardHeap cardHeap = cardHeaps.get(id);
        cardHeap.abandonCardFromCurrentExposedHeap(card);
        return "success";
    }

    @PutMapping("/{id}/expose")
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "牌堆编号", required = true, example = "1")
    @ApiOperation(value = "明置卡牌", notes = "根据url的id来指定更新对象，并根据传过来的卡牌信息将其明置")
    public String exposeCard(@PathVariable Long id, @RequestBody Card card) {
        CardHeap cardHeap = cardHeaps.get(id);
        cardHeap.exposeCard(card);
        return "success";
    }

    @PutMapping("/{id}/hide")
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "牌堆编号", required = true, example = "1")
    @ApiOperation(value = "暗置卡牌", notes = "根据url的id来指定更新对象，并根据传过来的卡牌信息将其暗置")
    public String hideCard(@PathVariable Long id, @RequestBody Card card) {
        CardHeap cardHeap = cardHeaps.get(id);
        cardHeap.hideCard(card);
        return "success";
    }

    @PutMapping("/{id}/refresh")
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "牌堆编号", required = true, example = "1")
    @ApiOperation(value = "刷新牌堆", notes = "将弃牌堆的所有牌加入牌堆")
    public String refreshCard(@PathVariable Long id) {
        CardHeap cardHeap = cardHeaps.get(id);
        cardHeap.refreshCard();
        return "success";
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除牌堆", notes = "根据url的id来指定删除对象")
    public String deleteCardHeap(@PathVariable Long id) {
        cardHeaps.remove(id);
        return "success";
    }
}
