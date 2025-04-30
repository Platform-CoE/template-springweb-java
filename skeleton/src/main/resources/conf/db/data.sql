INSERT INTO sampleUsers (username, email, password, role, enabled, created_at, created_by)
VALUES 
('admin', 'admin@example.com', '$2a$10$X7P3y85v0qZ6U3bN0YQw0eWQZJQJQJQJQJQJQJQJQJQJQJQJQ', 'ADMIN', true, NOW(), 'system'),
('user', 'user@example.com', '$2a$10$X7P3y85v0qZ6U3bN0YQw0eWQZJQJQJQJQJQJQJQJQJQJQJQJQ', 'USER', true, NOW(), 'system'); 