-- Seed data: migrate current frontend hardcoded content into the database.

-- Profile: seed from current siteConfig.js values.
UPDATE profile SET
    role_title = 'Backend Developer',
    availability_enabled = TRUE,
    availability_label = 'Open to Work'
WHERE id = 1;

-- Site Settings
UPDATE site_settings SET
    hero_eyebrow = 'Backend Developer',
    hero_heading = 'Hi, I''m',
    hero_supporting_text = 'I build REST APIs and database-driven applications with Java and Spring Boot, and have built full-stack and AI/ML projects.',
    hero_primary_cta_label = 'View Projects',
    hero_primary_cta_target = '#projects',
    hero_secondary_cta_label = 'Download Resume',
    hero_secondary_cta_target = '#resume',
    hero_visible = TRUE,
    contact_heading = 'Get in Touch',
    contact_headline = 'Open to backend and software engineering opportunities.',
    contact_visible = TRUE,
    footer_text = 'All rights reserved.',
    site_name = 'Deepesh Kumar Singh'
WHERE id = 1;

-- Education
UPDATE education SET
    degree = 'B.Tech',
    field_of_study = 'Computer Science & Engineering',
    institution = 'Shri Ramswaroop Memorial University',
    graduation_date = '2026',
    graduation_short = 'B.Tech CSE · 2026',
    visible = TRUE
WHERE id = 1;

-- Focus Items
INSERT INTO focus_items (label, display_order, visible) VALUES
    ('Backend Engineering', 1, TRUE),
    ('REST API Development', 2, TRUE),
    ('Databases', 3, TRUE),
    ('System Design', 4, TRUE),
    ('AI / ML', 5, TRUE);

-- Build Areas
INSERT INTO build_areas (title, description, icon_key, display_order, visible) VALUES
    ('Backend Systems', 'REST APIs, authentication, business logic and database-driven applications.', 'server', 1, TRUE),
    ('Full-Stack Applications', 'Modern React frontends connected to real backend APIs.', 'code', 2, TRUE),
    ('AI / ML Applications', 'AI-assisted tools, computer vision and machine-learning-powered applications.', 'sparkles', 3, TRUE);

-- Skill Categories
INSERT INTO skill_categories (name, icon_key, accent, display_order, visible) VALUES
    ('Backend', 'server', TRUE, 1, TRUE),
    ('Database', 'database', FALSE, 2, TRUE),
    ('DevOps & Tools', 'wrench', FALSE, 3, TRUE),
    ('Frontend', 'code', FALSE, 4, TRUE);

-- Skills: Backend (category 1)
INSERT INTO skills (category_id, name, display_order, visible) VALUES
    (1, 'Java', 1, TRUE),
    (1, 'Spring Boot', 2, TRUE),
    (1, 'REST APIs', 3, TRUE),
    (1, 'Spring Security', 4, TRUE),
    (1, 'JWT', 5, TRUE);

-- Skills: Database (category 2)
INSERT INTO skills (category_id, name, display_order, visible) VALUES
    (2, 'PostgreSQL', 1, TRUE),
    (2, 'MySQL', 2, TRUE);

-- Skills: DevOps & Tools (category 3)
INSERT INTO skills (category_id, name, display_order, visible) VALUES
    (3, 'Docker', 1, TRUE),
    (3, 'Git', 2, TRUE),
    (3, 'GitHub', 3, TRUE),
    (3, 'Postman', 4, TRUE),
    (3, 'IntelliJ IDEA', 5, TRUE),
    (3, 'VS Code', 6, TRUE);

-- Skills: Frontend (category 4)
INSERT INTO skills (category_id, name, display_order, visible) VALUES
    (4, 'React', 1, TRUE),
    (4, 'JavaScript', 2, TRUE),
    (4, 'HTML', 3, TRUE),
    (4, 'CSS', 4, TRUE),
    (4, 'Tailwind CSS', 5, TRUE),
    (4, 'Vite', 6, TRUE);

-- Exploration Items
INSERT INTO exploration_items (name, display_order, visible) VALUES
    ('Redis', 1, TRUE),
    ('Kubernetes', 2, TRUE),
    ('YAML', 3, TRUE),
    ('Cloud', 4, TRUE),
    ('System Design', 5, TRUE),
    ('Generative AI', 6, TRUE),
    ('Agentic AI', 7, TRUE);

-- Opportunity Types
INSERT INTO opportunity_types (label, display_order, visible) VALUES
    ('Backend Developer roles', 1, TRUE),
    ('Software engineering roles', 2, TRUE),
    ('Internships', 3, TRUE),
    ('Relevant collaborations', 4, TRUE);

-- Social Links: seed from profile GitHub/LinkedIn (if present).
-- These will be populated after the profile has URLs set.
-- Admin can manage these independently from profile.

-- Navigation Items
INSERT INTO navigation_items (label, href, display_order, visible, is_external) VALUES
    ('Home', '#home', 1, TRUE, FALSE),
    ('About', '#about', 2, TRUE, FALSE),
    ('Skills', '#skills', 3, TRUE, FALSE),
    ('Projects', '#projects', 4, TRUE, FALSE),
    ('Contact', '#contact', 5, TRUE, FALSE),
    ('Resume', '#resume', 6, TRUE, FALSE);

-- Section Settings
INSERT INTO section_settings (section_key, label, display_order, visible) VALUES
    ('hero', 'Hero', 1, TRUE),
    ('about', 'About', 2, TRUE),
    ('what-i-build', 'What I Build', 3, TRUE),
    ('skills', 'Skills', 4, TRUE),
    ('featured-project', 'Featured Project', 5, TRUE),
    ('projects', 'Projects', 6, TRUE),
    ('exploring', 'Currently Exploring', 7, TRUE),
    ('contact', 'Contact', 8, TRUE);

-- SEO Settings
UPDATE seo_settings SET
    page_title = 'Deepesh Kumar Singh — Backend Developer',
    meta_description = 'B.Tech CSE graduate and Backend Developer focused on Java, Spring Boot, REST APIs, PostgreSQL and modern backend systems. Open to backend and software engineering opportunities.',
    og_title = 'Deepesh Kumar Singh — Backend Developer',
    og_description = 'B.Tech CSE graduate and Backend Developer focused on Java, Spring Boot, REST APIs, PostgreSQL and modern backend systems. Open to backend and software engineering opportunities.',
    og_image_url = '/og.png',
    twitter_title = 'Deepesh Kumar Singh — Backend Developer',
    twitter_description = 'B.Tech CSE graduate and Backend Developer. Open to backend and software engineering opportunities.',
    robots = 'index, follow'
WHERE id = 1;
