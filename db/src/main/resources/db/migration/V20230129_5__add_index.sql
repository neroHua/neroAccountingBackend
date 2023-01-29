ALTER TABLE `tag` ADD INDEX key_parent_id (`parent_id`);
ALTER TABLE `accounting` ADD INDEX key_user_id (`user_id`);
ALTER TABLE `accounting` ADD INDEX key_bill_create_time (`bill_create_time`);
ALTER TABLE `accounting` ADD INDEX key_bill_money (`bill_money`);
ALTER TABLE `accounting_tag` ADD INDEX key_accounting_id (`accounting_id`);
ALTER TABLE `accounting_tag` ADD INDEX key_tag_id (`tag_id`);
