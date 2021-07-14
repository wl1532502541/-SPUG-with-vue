package com.meteor.scorpio.entity;


import com.meteor.scorpio.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Host extends BaseEntity implements Serializable {


    private String type;

    @Column(unique = true)
    private String hostName;

    private String userName;

    private String ip;

    private String port;

    private String secretKey;

    private String remarks;

    private String pKey;
}
