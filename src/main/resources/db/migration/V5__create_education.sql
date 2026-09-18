-- Singleton education record.
CREATE TABLE IF NOT EXISTS education (
    id BIGINT PRIMARY KEY DEFAULT 1,
    degree VARCHAR(255),
    field_of_study VARCHAR(255),
    institution VARCHAR(500),
    graduation_date VARCHAR(100),
    graduation_short VARCHAR(100),
    location VARCHAR(255),
    display_order INTEGER DEFAULT 0,
    visible BOOLEAN DEFAULT TRUE,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_education_singleton CHECK (id = 1)
);

INSERT INTO education (id) VALUES (1) ON CONFLICT (id) DO NOTHING;
