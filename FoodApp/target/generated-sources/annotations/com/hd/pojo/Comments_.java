package com.hd.pojo;

import com.hd.pojo.Store;
import com.hd.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-07T04:47:52")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, Date> createdDate;
    public static volatile SingularAttribute<Comments, Integer> id;
    public static volatile SingularAttribute<Comments, Store> storeId;
    public static volatile SingularAttribute<Comments, User> userId;
    public static volatile SingularAttribute<Comments, String> content;

}