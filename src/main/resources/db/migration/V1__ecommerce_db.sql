Create table if not exists checkout_cart(
    cart_id bigint not null GENERATED ALWAYS AS IDENTITY,
    item_id bigint,
    item_quantity double precision not null,
    item_unit_price double precision not null,
    item_total_price double precision not null,
    item_discount_percentage double precision not null,
    item_weight double precision not null
);

Create table if not exists weight_distance(
    price_id bigint not null GENERATED ALWAYS AS IDENTITY,
    weight_min double precision not null,
    weight_max double precision not null,
    min_distance double precision not null,
    max_distance double precision not null,
    relative_price double precision not null
);

insert into weight_distance(weight_min, weight_max,min_distane,max_distance,relative_price)
values(0,2,0,5,12);

