package com.github.as.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -2142761200L;

    public static final QUser user = new QUser("user");

    public final StringPath authCode = createString("authCode");

    public final StringPath email = createString("email");

    public final StringPath id = createString("id");

    public final StringPath initYn = createString("initYn");

    public final DatePath<java.sql.Date> lastLoginDate = createDate("lastLoginDate", java.sql.Date.class);

    public final StringPath password = createString("password");

    public final DatePath<java.sql.Date> regDate = createDate("regDate", java.sql.Date.class);

    public final StringPath userName = createString("userName");

    public final StringPath useYn = createString("useYn");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

