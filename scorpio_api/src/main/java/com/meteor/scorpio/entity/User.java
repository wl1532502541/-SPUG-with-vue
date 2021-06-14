package com.meteor.scorpio.entity;

import com.meteor.scorpio.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
@ApiModel(value = "User", description = "用户表")
public class User extends BaseEntity implements Serializable {

}
