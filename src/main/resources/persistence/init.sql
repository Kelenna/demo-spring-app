CREATE TABLE items (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255),
                       description VARCHAR(255)
);

INSERT INTO items (name, description)
    VALUES  ('Item 1', 'desc123'),
            ('Item 2', 'desc456'),
            ('Item 3', 'desc789'),
            ('Item 4', 'desc019');