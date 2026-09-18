-- Singleton SEO metadata.
CREATE TABLE IF NOT EXISTS seo_settings (
    id BIGINT PRIMARY KEY DEFAULT 1,
    page_title VARCHAR(255),
    meta_description VARCHAR(500),
    og_title VARCHAR(255),
    og_description VARCHAR(500),
    og_image_url VARCHAR(500),
    twitter_title VARCHAR(255),
    twitter_description VARCHAR(500),
    robots VARCHAR(100) DEFAULT 'index, follow',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_seo_settings_singleton CHECK (id = 1)
);

INSERT INTO seo_settings (id) VALUES (1) ON CONFLICT (id) DO NOTHING;
