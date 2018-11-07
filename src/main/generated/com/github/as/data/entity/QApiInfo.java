package com.github.as.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QApiInfo is a Querydsl query type for ApiInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApiInfo extends EntityPathBase<ApiInfo> {

    private static final long serialVersionUID = 446500995L;

    public static final QApiInfo apiInfo = new QApiInfo("apiInfo");

    public final StringPath contextPath = createString("contextPath");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath ip = createString("ip");

    public final StringPath port = createString("port");

    public final DatePath<java.sql.Date> regDate = createDate("regDate", java.sql.Date.class);

    public final StringPath serviceCode = createString("serviceCode");

    public final StringPath useYn = createString("useYn");

    public QApiInfo(String variable) {
        super(ApiInfo.class, forVariable(variable));
    }

    public QApiInfo(Path<? extends ApiInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApiInfo(PathMetadata metadata) {
        super(ApiInfo.class, metadata);
    }

}

