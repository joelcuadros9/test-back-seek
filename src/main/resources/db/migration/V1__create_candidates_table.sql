CREATE TABLE candidates (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(100) NOT NULL,
                            email VARCHAR(100) NOT NULL UNIQUE,
                            gender ENUM('MALE', 'FEMALE', 'OTHER') NOT NULL,
                            salary_expected DECIMAL(10, 2) NOT NULL,
                            experience_years INT NOT NULL,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
