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

package org.apache.tubemq.manager.service.tube;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.apache.tubemq.manager.service.tube.TubeHttpTopicInfoList.TopicInfoList.TopicInfo;

/**
 * json class for topic info list from master http service.
 */
@Data
public class TubeHttpTopicInfoList {
    private boolean result;

    private String errMsg;

    private int errCode;

    private List<TopicInfoList> data;

    @Data
    public static class TopicInfoList {

        @Data
        public static class TopicInfo {

            @Data
            public static class RunInfo {
                private boolean acceptPublish;
                private boolean acceptSubscribe;
                private int numPartitions;
                private int numTopicStores;
                private String brokerManageStatus;
            }


            private String topicName;
            private int topicStatusId;
            private int brokerId;
            private String brokerIp;
            private int brokerPort;
            private int numPartitions;
            private int unflushThreshold;
            private int unflushInterval;
            private int unFlushDataHold;
            private String deleteWhen;
            private String deletePolicy;
            private boolean acceptPublish;
            private boolean acceptSubscribe;
            private int numTopicStores;
            private int memCacheMsgSizeInMB;
            private int memCacheFlushIntvl;
            private int memCacheMsgCntInK;
            private String createUser;
            private String createDate;
            private String modifyUser;
            private String modifyDate;
            private RunInfo runInfo;

        }

        private String topicName;
        private List<TopicInfo> topicInfo;
    }


    public List<Integer> getTopicBrokerIdList() {
        List<Integer> tmpBrokerIdList = new ArrayList<>();
        if (data != null) {
            for (TopicInfoList topicInfoList : data) {
                if (topicInfoList.getTopicInfo() != null) {
                    for (TopicInfo topicInfo : topicInfoList.getTopicInfo()) {
                        tmpBrokerIdList.add(topicInfo.getBrokerId());
                    }
                }
            }
        }
        return tmpBrokerIdList;
    }
}
