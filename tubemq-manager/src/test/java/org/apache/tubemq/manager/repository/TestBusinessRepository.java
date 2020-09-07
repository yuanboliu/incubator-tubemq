package org.apache.tubemq.manager.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.apache.tubemq.manager.entry.BusinessEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestBusinessRepository {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BusinessRepository businessRepository;

    @Test
    public void whenFindByNameThenReturnBusiness() {
        BusinessEntry businessEntry = new BusinessEntry();
        String demoName = "alex";
        businessEntry.setBusinessName(demoName);
        businessEntry.setSchemaName(demoName);
        businessEntry.setTopic(demoName);
        businessEntry.setEncodingType(demoName);
        businessEntry.setUsername(demoName);
        businessEntry.setPasswd(demoName);
        entityManager.persist(businessEntry);
        entityManager.flush();

        BusinessEntry businessEntry1 = businessRepository.findByBusinessName("alex");
        assertThat(businessEntry1.getBusinessName()).isEqualTo(businessEntry.getBusinessName());
    }

    @Test
    public void checkValidation() throws Exception {
        BusinessEntry businessEntry = new BusinessEntry();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 512; i ++) {
            builder.append("a");
        }
        businessEntry.setBusinessName(builder.toString());
        try {

            entityManager.persist(businessEntry);
            entityManager.flush();
        } catch (Exception ex) {
            assertThat(ex.getMessage()).contains("must not be null", "size must be between");
        }
    }
}
