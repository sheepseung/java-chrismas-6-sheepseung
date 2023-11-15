package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {

    @Test
    @DisplayName("산타_뱃지_경계값_테스트")
    void getBadge_SantaBadgeAmount_ShouldReturnSantaBadge() {
        BigDecimal santaBadgeAmount = new BigDecimal(20000);
        assertEquals(Badge.SANTA_BADGE, Badge.getBadge(santaBadgeAmount));
    }

    @Test
    @DisplayName("트리_뱃지_경계값_테스트")
    void getBadge_BetweenTreeAndSantaAmount_ShouldReturnTreeBadge() {
        BigDecimal betweenTreeAndSantaAmount = new BigDecimal(15000);
        assertEquals(Badge.TREE_BADGE, Badge.getBadge(betweenTreeAndSantaAmount));
    }

    @Test
    @DisplayName("별_뱃지_경계값_테스트")
    void getBadge_StarBadgeAmount_ShouldReturnStarBadge() {
        BigDecimal starBadgeAmount = new BigDecimal(5000);
        assertEquals(Badge.STAR_BADGE, Badge.getBadge(starBadgeAmount));
    }
}
