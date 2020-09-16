/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
        String demoName = "alex";
        BusinessEntry businessEntry = new BusinessEntry(demoName, demoName,
                demoName, demoName, demoName, demoName);
        entityManager.persist(businessEntry);
        entityManager.flush();

        BusinessEntry businessEntry1 = businessRepository.findByBusinessName("alex");
        assertThat(businessEntry1.getBusinessName()).isEqualTo(businessEntry.getBusinessName());
    }

    @Test
    public void checkValidation() throws Exception {
        String demoName = "a";
        BusinessEntry businessEntry = new BusinessEntry(demoName, demoName, demoName,
                demoName, demoName, demoName);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 512; i ++) {
            builder.append("a");
        }
        businessEntry.setBusinessName(builder.toString());
        try {
            entityManager.persist(businessEntry);
            entityManager.flush();
        } catch (Exception ex) {
            assertThat(ex.getMessage()).contains("size must be between");
        }
    }
}
