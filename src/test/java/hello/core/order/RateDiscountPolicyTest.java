package hello.core.order;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("Vip 10%")
    void vip_o(){
        Member member = new Member(1L, "a", Grade.VIP);
        int discount = discountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Not vip 0%")
    void vip_x(){
        Member member = new Member(2L, "B", Grade.BASIC);
        int discount = discountPolicy.discount(member,10000);
        assertThat(discount).isEqualTo(0);
    }
}
