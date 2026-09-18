-- Add role_title to Profile for dynamic hero/navbar/footer role display.
ALTER TABLE profile ADD COLUMN IF NOT EXISTS role_title VARCHAR(255);
ALTER TABLE profile ADD COLUMN IF NOT EXISTS availability_enabled BOOLEAN DEFAULT TRUE;
ALTER TABLE profile ADD COLUMN IF NOT EXISTS availability_label VARCHAR(100) DEFAULT 'Open to Work';
