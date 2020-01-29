USE logistics

DROP TABLE IF EXISTS t_basicData;

DROP TABLE IF EXISTS t_customer;

DROP TABLE IF EXISTS t_menu;

DROP TABLE IF EXISTS t_order;

DROP TABLE IF EXISTS t_order_detail;

DROP TABLE IF EXISTS t_role;

DROP TABLE IF EXISTS t_role_menu;

DROP TABLE IF EXISTS t_user;

DROP TABLE IF EXISTS t_user_role;

/*==============================================================*/
/* Table: t_basicData                                           */
/*==============================================================*/
CREATE TABLE t_basicData
(
   base_id              INT NOT NULL AUTO_INCREMENT,
   parent_id            INT,
   base_name            VARCHAR(20) NOT NULL,
   base_desc            VARCHAR(30),
   PRIMARY KEY (base_id)
);

/*==============================================================*/
/* Table: t_customer                                            */
/*==============================================================*/
CREATE TABLE t_customer
(
   customer_id          INT NOT NULL AUTO_INCREMENT,
   order_id             INT,
   base_id              INT,
   user_id              INT,
   customer_name        VARCHAR(20) NOT NULL,
   mobile_phone         BIGINT,
   email                VARCHAR(30),
   address              VARCHAR(50),
   id_card              VARCHAR(18),
   c_sex                BOOL,
   remark               VARCHAR(200),
   PRIMARY KEY (customer_id)
);

/*==============================================================*/
/* Table: t_menu                                                */
/*==============================================================*/
CREATE TABLE t_menu
(
   menu_id              INT NOT NULL AUTO_INCREMENT,
   parent_menu_id       INT,
   menu_name            VARCHAR(20) NOT NULL,
   menu_desc            VARCHAR(30),
   menu_link            VARCHAR(50),
   security_name        VARCHAR(50),
   m1                   VARCHAR(20),
   m2                   VARCHAR(20),
   PRIMARY KEY (menu_id)
);

/*==============================================================*/
/* Table: t_order                                               */
/*==============================================================*/
CREATE TABLE t_order
(
   order_id             INT NOT NULL AUTO_INCREMENT,
   customer_id          INT,
   user_id              INT,
   shipping_address     VARCHAR(50),
   shipping_name        VARCHAR(20),
   shipping_phone       VARCHAR(13),
   take_name            VARCHAR(20),
   take_address         VARCHAR(50),
   take_phone           VARCHAR(13),
   order_desc           VARCHAR(100),
   order_status         TINYINT,
   payment_method_id    INT,
   dest_area_id         INT,
   trans_method_id      INT,
   take_method_id       INT,
   PRIMARY KEY (order_id)
);

/*==============================================================*/
/* Table: t_order_detail                                        */
/*==============================================================*/
CREATE TABLE t_order_detail
(
   order_detail_id      INT NOT NULL AUTO_INCREMENT,
   order_id             INT,
   goods_name           VARCHAR(30),
   goods_number         INT,
   goods_unit           INT,
   goods_unit_price     NUMERIC(10,2),
   goods_total          NUMERIC(10,2),
   goods_remark         VARCHAR(100),
   PRIMARY KEY (order_detail_id)
);

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
CREATE TABLE t_role
(
   role_id              INT NOT NULL AUTO_INCREMENT,
   role_name            VARCHAR(20) NOT NULL,
   role_desc            VARCHAR(30),
   PRIMARY KEY (role_id)
);

/*==============================================================*/
/* Table: t_role_menu                                           */
/*==============================================================*/
CREATE TABLE t_role_menu
(
   role_id              INT NOT NULL,
   menu_id              INT NOT NULL,
   PRIMARY KEY (role_id, menu_id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
CREATE TABLE t_user
(
   user_id              INT NOT NULL AUTO_INCREMENT,
   user_name            VARCHAR(20) NOT NULL,
   real_name            VARCHAR(20),
   PASSWORD             VARCHAR(16) NOT NULL,
   email                VARCHAR(30),
   phone                BIGINT,
   u1                   VARCHAR(20),
   u2                   VARCHAR(20),
   PRIMARY KEY (user_id)
);

/*==============================================================*/
/* Table: t_user_role                                           */
/*==============================================================*/
CREATE TABLE t_user_role
(
   user_id              INT NOT NULL,
   role_id              INT NOT NULL,
   PRIMARY KEY (user_id, role_id)
);

ALTER TABLE t_basicData ADD CONSTRAINT FK_sub_basic FOREIGN KEY (parent_id)
      REFERENCES t_basicData (base_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_customer ADD CONSTRAINT FK_Relationship_6 FOREIGN KEY (base_id)
      REFERENCES t_basicData (base_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_customer ADD CONSTRAINT FK_customer_order FOREIGN KEY (order_id)
      REFERENCES t_order (order_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_customer ADD CONSTRAINT FK_user_customer FOREIGN KEY (user_id)
      REFERENCES t_user (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_menu ADD CONSTRAINT FK_sub_menu FOREIGN KEY (parent_menu_id)
      REFERENCES t_menu (menu_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_order ADD CONSTRAINT FK_customer_order2 FOREIGN KEY (customer_id)
      REFERENCES t_customer (customer_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_order ADD CONSTRAINT FK_user_order FOREIGN KEY (user_id)
      REFERENCES t_user (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_order_detail ADD CONSTRAINT FK_order_orderdetail FOREIGN KEY (order_id)
      REFERENCES t_order (order_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_role_menu ADD CONSTRAINT FK_t_role_menu FOREIGN KEY (role_id)
      REFERENCES t_role (role_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_role_menu ADD CONSTRAINT FK_t_role_menu2 FOREIGN KEY (menu_id)
      REFERENCES t_menu (menu_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_user_role ADD CONSTRAINT FK_t_user_role FOREIGN KEY (user_id)
      REFERENCES t_user (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_user_role ADD CONSTRAINT FK_t_user_role2 FOREIGN KEY (role_id)
      REFERENCES t_role (role_id) ON DELETE RESTRICT ON UPDATE RESTRICT;