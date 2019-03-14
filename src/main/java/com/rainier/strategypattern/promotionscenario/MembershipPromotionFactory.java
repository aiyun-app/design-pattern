package com.rainier.strategypattern.promotionscenario;

import java.util.HashMap;
import java.util.Map;

public class MembershipPromotionFactory {

    private static Map<MembershipLevel, MembershipPromotion> map = new HashMap<>();
    static {
        map.put(MembershipLevel.NA, new DefaultMembershipPromotion());
        map.put(MembershipLevel.SILVER, new SilverMembershipPromotion());
        map.put(MembershipLevel.GOLD, new GoldenMembershipPromotion());
        map.put(MembershipLevel.DIAMOND, new DiamondMembershipPromotion());
    }

    public static MembershipPromotion getPromotion(String membershipLevel){
        MembershipLevel level = MembershipLevel.valueOf(membershipLevel);
        if (level == null)
            level = MembershipLevel.NA;
        return map.get(level);
    }
}
