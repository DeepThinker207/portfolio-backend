-- Singleton table for global site settings (hero, contact, SEO, footer).
CREATE TABLE IF NOT EXISTS site_settings (
    id BIGINT PRIMARY KEY DEFAULT 1,
    -- Hero
    hero_eyebrow VARCHAR(255),
    hero_heading VARCHAR(255),
    hero_supporting_text TEXT,
    hero_primary_cta_label VARCHAR(255) DEFAULT 'View Projects',
    hero_primary_cta_target VARCHAR(255) DEFAULT '#projects',
    hero_secondary_cta_label VARCHAR(255),
    hero_secondary_cta_target VARCHAR(500),
    hero_visible BOOLEAN DEFAULT TRUE,
    -- Contact
    contact_heading VARCHAR(500) DEFAULT 'Get in Touch',
    contact_headline VARCHAR(500) DEFAULT 'Open to backend and software engineering opportunities.',
    contact_visible BOOLEAN DEFAULT TRUE,
    -- Footer
    footer_text VARCHAR(500) DEFAULT 'All rights reserved.',
    -- Global
    site_name VARCHAR(255),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_site_settings_singleton CHECK (id = 1)
);

INSERT INTO site_settings (id) VALUES (1) ON CONFLICT (id) DO NOTHING;
