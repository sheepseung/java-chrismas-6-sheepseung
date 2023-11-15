package christmas.domain;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {

    @Test
    void getBadge_SantaBadgeAmount_ShouldReturnSantaBadge() {
        BigDecimal santaBadgeAmount = new BigDecimal(20000);
        assertEquals(Badge.SANTA_BADGE, Badge.getBadge(santaBadgeAmount));
    }

    @Test
    void getBadge_BetweenTreeAndSantaAmount_ShouldReturnTreeBadge() {
        BigDecimal betweenTreeAndSantaAmount = new BigDecimal(15000);
        assertEquals(Badge.TREE_BADGE, Badge.getBadge(betweenTreeAndSantaAmount));
    }

    @Test
    void getBadge_StarBadgeAmount_ShouldReturnStarBadge() {
        BigDecimal starBadgeAmount = new BigDecimal(5000);
        assertEquals(Badge.STAR_BADGE, Badge.getBadge(starBadgeAmount));
    }
}
