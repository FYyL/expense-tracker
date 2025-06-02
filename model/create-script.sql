/** START 02/06/2025 **/
CREATE TABLE expense_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(32),
    amount DOUBLE,
    description VARCHAR(255),
    date DATE,
    create_timestamp TIMESTAMP,
    update_timestamp TIMESTAMP,
    status VARCHAR(32)
);
/** END 02/06/2025 **/