alter table cats add column date_of_birth date;

update cats set date_of_birth=current_date- interval '1 month'* age_in_months;

alter table cats drop column age_in_months;
