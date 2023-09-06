package com.example.tikatest.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author 张峰
 * @since 2022-04-22
 */
@Getter
@Setter
@Accessors(chain = true)
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String name;

  private String password;


}
