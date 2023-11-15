package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    @DisplayName("메뉴_찾기_함수_테스트")
    void findMenu_ExistingMenuName_ShouldReturnMenu() {
        String existingMenuName = "티본스테이크";
        Menu foundMenu = Menu.findMenu(existingMenuName);
        assertNotNull(foundMenu);
        assertEquals(existingMenuName, foundMenu.getMenuItem().getName());
    }

    @Test
    @DisplayName("메뉴_찾기_함수_예외_테스트")
    void findMenu_NonExistingMenuName_ShouldThrowException() {
        String nonExistingMenuName = "피자";
        assertThrows(IllegalArgumentException.class, () -> Menu.findMenu(nonExistingMenuName));
    }
}
