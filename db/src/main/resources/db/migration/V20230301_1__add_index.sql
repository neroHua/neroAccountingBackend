ALTER TABLE `accounting_tag` ADD CONSTRAINT unique_accounting_id_tag_id UNIQUE(`accounting_id`, `tag_id`);
