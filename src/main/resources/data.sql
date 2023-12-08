-- Dodanie użytkowników
INSERT INTO app_users (first_name, last_name, email, phone_number, login, password, birth_date, address_id) VALUES
('Jan', 'Kowalski', 'jan@example.com', '123456789', 'jankowalski', 'password123', '1990-01-01', NULL),
('Anna', 'Nowak', 'anna.nowak@example.com', '987654321', 'annanowak', 'password123', '1992-02-02', NULL);

-- Dodanie klientów
INSERT INTO customer (type, driving_license_number, card_number, user_id) VALUES
('premium', 'DL12345', 1234567890123456, 1),
('dflt', 'DL67890', 6543210987654321, 2);
