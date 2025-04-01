INSERT INTO customer (created_at, updated_at, firstName, lastName, email, password, role)
VALUES
    (NOW(), NOW(), 'firstName 1','lastName1' ,'customer1@example.com', '$2a$10$XURP2yW8L3X8m1f3f1f3f.f3f3f3f3f3f3f3f3f3f3f3f3f3f3f', 'ROLE_CUSTOMER'),
    (NOW(), NOW(), 'firstName 2','lastName 2','customer2@example.com', '$2a$10$XURP2yW8L3X8m1f3f1f3f.f3f3f3f3f3f3f3f3f3f3f3f3f3f3f', 'ROLE_CUSTOMER');

INSERT INTO biker (created_at, updated_at, firstName, lastName, email, average_rating)
VALUES
    (NOW(), NOW(), 'firstName One','lastName one', 'biker1@example.com', 4.5),
    (NOW(), NOW(), 'firstName Two','lastName two', 'biker2@example.com', 4.8);