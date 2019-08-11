package com.sb.dbspring.user.infrastructure;

import com.sb.dbspring.user.domain.Customer;
import com.sb.dbspring.user.domain.Staff;
import com.sb.dbspring.user.domain.User;
import com.sb.dbspring.user.domain.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HbUsersTest {

    @Autowired
    Users users;

    @Test
    public void testPolymorphism() {
        var user = new User();
        user.setId(UUID.randomUUID());
        user.setLogin("userLogin");

        this.users.save(user);

        user = new Customer();
        user.setId(UUID.randomUUID());
        user.setLogin("customerLogin");

        this.users.save(user);

        user = new Staff();
        user.setId(UUID.randomUUID());
        user.setLogin("staffLogin");

        this.users.save(user);

        assertThat(this.users.findByLogin("userLogin")).get().isExactlyInstanceOf(User.class);

        assertThat(this.users.findByLogin("customerLogin")).get().isInstanceOf(User.class);
        assertThat(this.users.findByLogin("customerLogin")).get().isExactlyInstanceOf(Customer.class);

        assertThat(this.users.findByLogin("staffLogin")).get().isInstanceOf(User.class);
        assertThat(this.users.findByLogin("staffLogin")).get().isExactlyInstanceOf(Staff.class);

    }

    @Test
    public void saveShouldPersistData() {
        final var user = new Customer();
        final UUID id = UUID.randomUUID();
        user.setId(id);
        user.setLogin("customer1");
        user.setPassword("passw0rd");
        user.setPurchasedProductNo(5);

        this.users.save(user);

        final Optional<User> out = this.users.get(id.toString());
        assertThat(out).isPresent();

        final Integer purchasedProductNo = ((Customer) out.get()).getPurchasedProductNo();
        assertThat(purchasedProductNo).isEqualTo(5);
    }

    @Test
    public void findByLoginShouldRetrieveUser() {
        final var user = new User();
        final UUID id = UUID.randomUUID();
        user.setId(id);
        user.setLogin("userLogin");

        this.users.save(user);

        assertThat(this.users.findByLogin("userLogin")).isPresent();
    }

}