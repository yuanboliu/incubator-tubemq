package org.apache.tubemq.manager.entry;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "business")
public class BusinessEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long businessId;

    @Size(max = 30)
    @NotNull
    private String businessName;

    @Size(max = 64)
    private String messageType;

    @Size(max = 256)
    private String businessCnName;

    @Size(max = 256)
    private String description;

    private String bg;

    @Size(max = 240)
    @NotNull
    private String schemaName;

    @Size(max = 32)
    @NotNull
    private String username;

    @Size(max = 64)
    @NotNull
    private String passwd;

    @Size(max = 64)
    @NotNull
    private String topic;

    @Size(max = 10)
    private String fieldSplitter;

    @Size(max = 256)
    private String predefinedFields;

    private int isHybridDataSource = 0;

    @Size(max = 64)
    @NotNull
    private String encodingType;

    private int isSubSort = 0;

    private String topologyName;

    private String targetServer;

    private String targetServerPort;

    private String netTarget;

    private int status;

    private String category;

    private int clusterId;

    private String inCharge;

    private String sourceServer;

    private String baseDir;

    private Timestamp createTime;

    private String importType;

    private String exampleData;

    private String tdwAppgroup;

    @Column(name = "SN")
    private int sn;

    @Size(max = 32)
    private String issueMethod;

    public long getBusinessId() {
        return businessId;
    }

    public String getEncodingType() {
        return encodingType;
    }

    public void setEncodingType(String encodingType) {
        this.encodingType = encodingType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String name) {
        this.businessName = name;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
