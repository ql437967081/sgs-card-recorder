package edu.nju.wsql.sgscardrecorder.model;

import edu.nju.wsql.sgscardrecorder.model.enums.Suit;
import lombok.Data;

import java.util.*;

@Data
public class CardHeap {
    private static final Map<String, List<Card>> ALL_CARDS;

    private static int[] ALL_SUIT_NUM;

    private static Map<String, Integer> ALL_POINT_NUM;

    static {
        ALL_CARDS = new HashMap<>();
        addAll基本牌();
        addAll装备牌();
        addAll锦囊牌();

        ALL_SUIT_NUM = new int[Suit.values().length];
        Arrays.fill(ALL_SUIT_NUM, 0);

        ALL_POINT_NUM = new HashMap<>();

        for (List<Card> cards: ALL_CARDS.values()) {
            for (Card card: cards) {
                ALL_SUIT_NUM[card.getSuit().ordinal()]++;
                String point = card.getPoint();
                if (!ALL_POINT_NUM.containsKey(point))
                    ALL_POINT_NUM.put(point, 1);
                else
                    ALL_POINT_NUM.put(point, ALL_POINT_NUM.get(point) + 1);
            }
        }
        /*
        for (Suit suit: Suit.values()) {
            System.out.println(suit + ": " + ALL_SUIT_NUM[suit.ordinal()]);
        }

        for (String point: ALL_POINT_NUM.keySet()) {
            System.out.println(point + ": " + ALL_POINT_NUM.get(point));
        }
        //*/
    }

    private static void addAll基本牌() {
        addAll桃();
        addAll闪();
        addAll酒();
        addAll杀();
        addAll雷杀();
        addAll火杀();
    }

    private static void addAll装备牌() {
        addAll加一马();
        addAll减一马();
        addAll防具();
        addAll武器();
    }

    private static void addAll锦囊牌() {
        addAll延时锦囊();
        addAll非延时锦囊();
    }

    private static void addAll非延时锦囊() {
        addAll全角色锦囊();
        addAll多角色锦囊();
        addAll单角色锦囊();
        addAll无角色锦囊();
    }

    private static void addAll桃() {
        List<Card> 桃 = new ArrayList<>();
        桃.add(new Card(Suit.Diamond, "2"));
        桃.add(new Card(Suit.Heart, "4"));
        桃.add(new Card(Suit.Heart, "6"));
        桃.add(new Card(Suit.Heart, "7"));
        桃.add(new Card(Suit.Heart, "8"));
        桃.add(new Card(Suit.Heart, "9"));
        桃.add(new Card(Suit.Heart, "10"));
        桃.add(new Card(Suit.Heart, "Q"));
        ALL_CARDS.put("桃", 桃);
    }

    private static void addAll闪() {
        List<Card> 闪 = new ArrayList<>();
        闪.add(new Card(Suit.Diamond, "2"));
        闪.add(new Card(Suit.Diamond, "3"));
        闪.add(new Card(Suit.Diamond, "6"));
        闪.add(new Card(Suit.Diamond, "7"));
        闪.add(new Card(Suit.Diamond, "7"));
        闪.add(new Card(Suit.Diamond, "8"));
        闪.add(new Card(Suit.Diamond, "8"));
        闪.add(new Card(Suit.Diamond, "9"));
        闪.add(new Card(Suit.Diamond, "10"));
        闪.add(new Card(Suit.Diamond, "J"));
        闪.add(new Card(Suit.Diamond, "K"));
        闪.add(new Card(Suit.Heart, "2"));
        闪.add(new Card(Suit.Heart, "J"));
        闪.add(new Card(Suit.Heart, "K"));
        ALL_CARDS.put("闪", 闪);
    }

    private static void addAll酒() {
        List<Card> 酒 = new ArrayList<>();
        酒.add(new Card(Suit.Diamond, "9"));
        酒.add(new Card(Suit.Spade, "9"));
        酒.add(new Card(Suit.Club, "9"));
        ALL_CARDS.put("酒", 酒);
    }

    private static void addAll杀() {
        List<Card> 杀 = new ArrayList<>();
        杀.add(new Card(Suit.Diamond, "10"));
        杀.add(new Card(Suit.Diamond, "J"));
        杀.add(new Card(Suit.Diamond, "Q"));
        杀.add(new Card(Suit.Spade, "5"));
        杀.add(new Card(Suit.Spade, "7"));
        杀.add(new Card(Suit.Spade, "8"));
        杀.add(new Card(Suit.Spade, "8"));
        杀.add(new Card(Suit.Spade, "9"));
        杀.add(new Card(Suit.Spade, "10"));
        杀.add(new Card(Suit.Spade, "J"));
        杀.add(new Card(Suit.Heart, "10"));
        杀.add(new Card(Suit.Heart, "Q"));
        杀.add(new Card(Suit.Club, "2"));
        杀.add(new Card(Suit.Club, "3"));
        杀.add(new Card(Suit.Club, "4"));
        杀.add(new Card(Suit.Club, "5"));
        杀.add(new Card(Suit.Club, "8"));
        杀.add(new Card(Suit.Club, "9"));
        杀.add(new Card(Suit.Club, "10"));
        杀.add(new Card(Suit.Club, "J"));
        杀.add(new Card(Suit.Club, "J"));
        ALL_CARDS.put("杀", 杀);
    }

    private static void addAll雷杀() {
        List<Card> 雷杀 = new ArrayList<>();
        雷杀.add(new Card(Suit.Spade, "6"));
        雷杀.add(new Card(Suit.Spade, "7"));
        雷杀.add(new Card(Suit.Club, "6"));
        雷杀.add(new Card(Suit.Club, "7"));
        雷杀.add(new Card(Suit.Club, "8"));
        ALL_CARDS.put("雷杀", 雷杀);
    }

    private static void addAll火杀() {
        List<Card> 火杀 = new ArrayList<>();
        火杀.add(new Card(Suit.Diamond, "4"));
        火杀.add(new Card(Suit.Diamond, "5"));
        火杀.add(new Card(Suit.Heart, "4"));
        ALL_CARDS.put("火杀", 火杀);
    }

    private static void addAll加一马() {
        List<Card> 加一马 = new ArrayList<>();
        加一马.add(new Card(Suit.Heart, "K"));
        加一马.add(new Card(Suit.Spade, "5"));
        加一马.add(new Card(Suit.Club, "5"));
        ALL_CARDS.put("加一马", 加一马);
    }

    private static void addAll减一马() {
        List<Card> 减一马 = new ArrayList<>();
        减一马.add(new Card(Suit.Heart, "5"));
        减一马.add(new Card(Suit.Diamond, "K"));
        减一马.add(new Card(Suit.Spade, "K"));
        ALL_CARDS.put("减一马", 减一马);
    }

    private static void addAll防具() {
        List<Card> 藤甲 = new ArrayList<>();
        藤甲.add(new Card(Suit.Club, "2"));
        ALL_CARDS.put("藤甲", 藤甲);

        List<Card> 白银狮子 = new ArrayList<>();
        白银狮子.add(new Card(Suit.Club, "A"));
        ALL_CARDS.put("白银狮子", 白银狮子);

        List<Card> 仁王盾 = new ArrayList<>();
        仁王盾.add(new Card(Suit.Club, "2"));
        ALL_CARDS.put("仁王盾", 仁王盾);

        List<Card> 八卦阵 = new ArrayList<>();
        八卦阵.add(new Card(Suit.Spade, "2"));
        ALL_CARDS.put("八卦阵", 八卦阵);
    }

    private static void addAll武器() {
        List<Card> 麒麟弓 = new ArrayList<>();
        麒麟弓.add(new Card(Suit.Heart, "5"));
        ALL_CARDS.put("麒麟弓", 麒麟弓);

        List<Card> 朱雀羽扇 = new ArrayList<>();
        朱雀羽扇.add(new Card(Suit.Diamond, "A"));
        ALL_CARDS.put("朱雀羽扇", 朱雀羽扇);

        List<Card> 丈八蛇矛 = new ArrayList<>();
        丈八蛇矛.add(new Card(Suit.Spade, "Q"));
        ALL_CARDS.put("丈八蛇矛", 丈八蛇矛);

        List<Card> 贯石斧 = new ArrayList<>();
        贯石斧.add(new Card(Suit.Diamond, "5"));
        ALL_CARDS.put("贯石斧", 贯石斧);

        List<Card> 三尖两刃刀 = new ArrayList<>();
        三尖两刃刀.add(new Card(Suit.Diamond, "Q"));
        ALL_CARDS.put("三尖两刃刀", 三尖两刃刀);

        List<Card> 吴六剑 = new ArrayList<>();
        吴六剑.add(new Card(Suit.Diamond, "6"));
        ALL_CARDS.put("吴六剑", 吴六剑);

        List<Card> 寒冰剑 = new ArrayList<>();
        寒冰剑.add(new Card(Suit.Spade, "2"));
        ALL_CARDS.put("寒冰剑", 寒冰剑);

        List<Card> 雌雄双股剑 = new ArrayList<>();
        雌雄双股剑.add(new Card(Suit.Spade, "2"));
        ALL_CARDS.put("雌雄双股剑", 雌雄双股剑);

        List<Card> 青釭剑 = new ArrayList<>();
        青釭剑.add(new Card(Suit.Spade, "6"));
        ALL_CARDS.put("青釭剑", 青釭剑);

        List<Card> 诸葛连弩 = new ArrayList<>();
        诸葛连弩.add(new Card(Suit.Diamond, "A"));
        ALL_CARDS.put("诸葛连弩", 诸葛连弩);
    }

    private static void addAll延时锦囊() {
        List<Card> 兵粮寸断 = new ArrayList<>();
        兵粮寸断.add(new Card(Suit.Spade, "10"));
        兵粮寸断.add(new Card(Suit.Club, "10"));
        ALL_CARDS.put("兵粮寸断", 兵粮寸断);

        List<Card> 乐不思蜀 = new ArrayList<>();
        乐不思蜀.add(new Card(Suit.Heart, "6"));
        乐不思蜀.add(new Card(Suit.Club, "6"));
        ALL_CARDS.put("乐不思蜀", 乐不思蜀);

        List<Card> 闪电 = new ArrayList<>();
        闪电.add(new Card(Suit.Spade, "A"));
        ALL_CARDS.put("闪电", 闪电);
    }

    private static void addAll全角色锦囊() {
        List<Card> 五谷丰登 = new ArrayList<>();
        五谷丰登.add(new Card(Suit.Heart, "3"));
        ALL_CARDS.put("五谷丰登", 五谷丰登);

        List<Card> 桃园结义 = new ArrayList<>();
        桃园结义.add(new Card(Suit.Heart, "A"));
        ALL_CARDS.put("桃园结义", 桃园结义);

        List<Card> 万箭齐发 = new ArrayList<>();
        万箭齐发.add(new Card(Suit.Heart, "A"));
        ALL_CARDS.put("万箭齐发", 万箭齐发);

        List<Card> 南蛮入侵 = new ArrayList<>();
        南蛮入侵.add(new Card(Suit.Spade, "K"));
        南蛮入侵.add(new Card(Suit.Club, "7"));
        ALL_CARDS.put("南蛮入侵", 南蛮入侵);
    }

    private static void addAll多角色锦囊() {
        List<Card> 以逸待劳 = new ArrayList<>();
        以逸待劳.add(new Card(Suit.Diamond, "4"));
        以逸待劳.add(new Card(Suit.Heart, "J"));
        ALL_CARDS.put("以逸待劳", 以逸待劳);

        List<Card> 铁索连环 = new ArrayList<>();
        铁索连环.add(new Card(Suit.Spade, "Q"));
        铁索连环.add(new Card(Suit.Club, "Q"));
        铁索连环.add(new Card(Suit.Club, "K"));
        ALL_CARDS.put("铁索连环", 铁索连环);
    }

    private static void addAll单角色锦囊() {
        List<Card> 远交近攻 = new ArrayList<>();
        远交近攻.add(new Card(Suit.Heart, "9"));
        ALL_CARDS.put("远交近攻", 远交近攻);

        List<Card> 知己知彼 = new ArrayList<>();
        知己知彼.add(new Card(Suit.Club, "3"));
        知己知彼.add(new Card(Suit.Club, "4"));
        ALL_CARDS.put("知己知彼", 知己知彼);

        List<Card> 火攻 = new ArrayList<>();
        火攻.add(new Card(Suit.Heart, "2"));
        火攻.add(new Card(Suit.Heart, "3"));
        ALL_CARDS.put("火攻", 火攻);

        List<Card> 借刀杀人 = new ArrayList<>();
        借刀杀人.add(new Card(Suit.Club, "Q"));
        ALL_CARDS.put("借刀杀人", 借刀杀人);

        List<Card> 顺手牵羊 = new ArrayList<>();
        顺手牵羊.add(new Card(Suit.Diamond, "3"));
        顺手牵羊.add(new Card(Suit.Spade, "3"));
        顺手牵羊.add(new Card(Suit.Spade, "4"));
        ALL_CARDS.put("顺手牵羊", 顺手牵羊);

        List<Card> 过河拆桥 = new ArrayList<>();
        过河拆桥.add(new Card(Suit.Heart, "Q"));
        过河拆桥.add(new Card(Suit.Spade, "3"));
        过河拆桥.add(new Card(Suit.Spade, "4"));
        ALL_CARDS.put("过河拆桥", 过河拆桥);

        List<Card> 无中生有 = new ArrayList<>();
        无中生有.add(new Card(Suit.Heart, "7"));
        无中生有.add(new Card(Suit.Heart, "8"));
        ALL_CARDS.put("无中生有", 无中生有);

        List<Card> 决斗 = new ArrayList<>();
        决斗.add(new Card(Suit.Spade, "A"));
        决斗.add(new Card(Suit.Club, "A"));
        ALL_CARDS.put("决斗", 决斗);
    }

    private static void addAll无角色锦囊() {
        List<Card> 无懈可击 = new ArrayList<>();
        无懈可击.add(new Card(Suit.Spade, "J"));
        ALL_CARDS.put("无懈可击", 无懈可击);

        List<Card> 无懈可击_国 = new ArrayList<>();
        无懈可击_国.add(new Card(Suit.Diamond, "Q"));
        无懈可击_国.add(new Card(Suit.Club, "K"));
        ALL_CARDS.put("无懈可击•国", 无懈可击_国);
    }

    private Map<String, List<Card>> currentHeap;

    private int[] suitNum;

    private Map<String, List<Card>> currentExposedHeap;

    private int[] exposedSuitNum;

    public CardHeap() {
        currentHeap = new HashMap<>();
        currentExposedHeap = new HashMap<>();
        for (Map.Entry<String, List<Card>> entry: ALL_CARDS.entrySet()) {
            String name = entry.getKey();
            currentHeap.put(name, new ArrayList<>(entry.getValue()));
            currentExposedHeap.put(name, new ArrayList<>());
        }
        suitNum = Arrays.copyOf(ALL_SUIT_NUM, ALL_SUIT_NUM.length);
        exposedSuitNum = new int[ALL_SUIT_NUM.length];
        Arrays.fill(exposedSuitNum, 0);
    }

    public synchronized void abandonCardFromCurrentHeap(Card toAbandon) {
        abandonCard(toAbandon, currentHeap, suitNum);
    }

    public synchronized void abandonCardFromCurrentExposedHeap(Card toAbandon) {
        abandonCard(toAbandon, currentExposedHeap, exposedSuitNum);
    }

    private void abandonCard(Card toAbandon, Map<String, List<Card>> heap, int[] sn) {
        if (!heap.containsKey(toAbandon.getName()))
            return;

        Card toSelect = findTarget(toAbandon, heap);
        if (toSelect != null) {
            heap.get(toAbandon.getName()).remove(toSelect);
            sn[toSelect.getSuit().ordinal()]--;
        }
    }

    private Card findTarget(Card target, Map<String, List<Card>> heap) {
        Card toSelect = null;
        for (Card card: heap.get(target.getName())) {
            if (card.getSuit() == target.getSuit())
                if (card.getPoint().equals(target.getPoint())) {
                    toSelect = card;
                    break;
                }
        }
        return toSelect;
    }

    public synchronized void exposeCard(Card toExpose) {
        changePlaceOfCard(toExpose, currentHeap, currentExposedHeap, suitNum, exposedSuitNum);
    }

    public synchronized void hideCard(Card toHide) {
        changePlaceOfCard(toHide, currentExposedHeap, currentHeap, exposedSuitNum, suitNum);
    }

    private void changePlaceOfCard(Card card,
                                   Map<String, List<Card>> fromHeap, Map<String, List<Card>> toHeap,
                                   int[] fromSuitNum, int[] toSuitNum) {
        if (!fromHeap.containsKey(card.getName()))
            return;

        Card toSelect = findTarget(card, fromHeap);
        if (toSelect != null) {
            String name = card.getName();
            fromHeap.get(name).remove(toSelect);
            toHeap.get(name).add(toSelect);
            int i = toSelect.getSuit().ordinal();
            fromSuitNum[i]--;
            toSuitNum[i]++;
        }
    }

    public synchronized void refreshCard() {
        for (Map.Entry<String, List<Card>> entry: ALL_CARDS.entrySet()) {
            String name = entry.getKey();
            List<Card> cards = new ArrayList<>();
            for (Card card: entry.getValue()) {
                if (!isExposed(card, name))
                    cards.add(card);
            }
            currentHeap.put(name, new ArrayList<>(cards));
        }

        for (int i = 0; i < ALL_SUIT_NUM.length; i++) {
            suitNum[i] = ALL_SUIT_NUM[i] - exposedSuitNum[i];
        }
    }

    private boolean isExposed(Card card, String name) {
        for (Card card1: currentExposedHeap.get(name)) {
            if (card == card1)
                return true;
        }
        return false;
    }
}
