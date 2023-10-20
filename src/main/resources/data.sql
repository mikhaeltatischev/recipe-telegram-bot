TRUNCATE services CASCADE;
TRUNCATE masters CASCADE;

INSERT INTO masters (id, name, russian_name)
VALUES (2325318, 'dariya', 'Дарья'),
       (1884624, 'anna', 'Анна');

INSERT INTO services (id, master_id, name)
VALUES (9297502, 1884624, 'extension'),
       (10038150, 2325318, 'combmanicure'),
       (10038110, 2325318, 'plain'),
       (10038122, 2325318, 'design'),
       (10038130, 2325318, 'strength'),

       (10038172, 1884624, 'combmanicure'),
       (9297498, 1884624, 'plain'),
       (10038482, 1884624, 'design'),
       (9297552, 1884624, 'strength'),

       (11157850, 2325318, 'paltikispork'),
       (11157818, 2325318, 'polnbezpokr'),
       (11157868, 2325318, 'polnpokr');