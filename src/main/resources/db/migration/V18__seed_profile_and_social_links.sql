-- Seed the profile row (id = 1) which the application always loads, plus the
-- social links, from the verified production credentials and the former
-- frontend fallback content.

-- Insert the profile row if it does not exist yet. Existing production rows
-- are never overwritten by this statement.
INSERT INTO profile (
    id,
    name,
    bio,
    email,
    location,
    github_url,
    linkedin_url,
    resume_url,
    role_title,
    availability_enabled,
    availability_label
) VALUES (
    1,
    'Deepesh Kumar Singh',
    'I''m a B.Tech Computer Science graduate (2026) focused on backend development. I build REST APIs, design database schemas and write Java / Spring Boot services.'
    || chr(10) || chr(10)
    || 'I''ve also built full-stack applications spanning database, API and React frontend development, along with AI/ML-powered tools.'
    || chr(10) || chr(10)
    || 'I''m currently looking for backend and software engineering opportunities.',
    'deepeshintech@gmail.com',
    'Kishanganj, Bihar, India',
    'https://github.com/DeepThinker207',
    'https://www.linkedin.com/in/deepesh-kumar-singh-/',
    NULL,
    'Backend Developer',
    TRUE,
    'Open to Work'
) ON CONFLICT (id) DO NOTHING;

-- Backfill any empty/missing profile fields without clobbering existing data.
UPDATE profile SET
    name = COALESCE(NULLIF(name, ''), 'Deepesh Kumar Singh'),
    bio = COALESCE(NULLIF(bio, ''),
        'I''m a B.Tech Computer Science graduate (2026) focused on backend development. I build REST APIs, design database schemas and write Java / Spring Boot services.'
        || chr(10) || chr(10)
        || 'I''ve also built full-stack applications spanning database, API and React frontend development, along with AI/ML-powered tools.'
        || chr(10) || chr(10)
        || 'I''m currently looking for backend and software engineering opportunities.'),
    email = COALESCE(NULLIF(email, ''), 'deepeshintech@gmail.com'),
    location = COALESCE(NULLIF(location, ''), 'Kishanganj, Bihar, India'),
    github_url = COALESCE(NULLIF(github_url, ''), 'https://github.com/DeepThinker207'),
    linkedin_url = COALESCE(NULLIF(linkedin_url, ''), 'https://www.linkedin.com/in/deepesh-kumar-singh-/'),
    role_title = COALESCE(NULLIF(role_title, ''), 'Backend Developer'),
    availability_enabled = COALESCE(availability_enabled, TRUE),
    availability_label = COALESCE(NULLIF(availability_label, ''), 'Open to Work')
WHERE id = 1;

-- Social links. Each insert is guarded so existing admin-managed links survive.
INSERT INTO social_links (platform, label, url, icon_key, display_order, visible)
SELECT 'github', 'GitHub', 'https://github.com/DeepThinker207', 'github', 1, TRUE
WHERE NOT EXISTS (SELECT 1 FROM social_links WHERE platform = 'github');

INSERT INTO social_links (platform, label, url, icon_key, display_order, visible)
SELECT 'linkedin', 'LinkedIn', 'https://www.linkedin.com/in/deepesh-kumar-singh-/', 'linkedin', 2, TRUE
WHERE NOT EXISTS (SELECT 1 FROM social_links WHERE platform = 'linkedin');

INSERT INTO social_links (platform, label, url, icon_key, display_order, visible)
SELECT 'email', 'Email', 'mailto:deepeshintech@gmail.com', 'email', 3, TRUE
WHERE NOT EXISTS (SELECT 1 FROM social_links WHERE platform = 'email');