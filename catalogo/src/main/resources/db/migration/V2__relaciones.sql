ALTER TABLE events
    ADD CONSTRAINT fk_events_venues
        FOREIGN KEY (venue_id) REFERENCES venues(id);

ALTER TABLE events
    ADD CONSTRAINT uq_event_name UNIQUE (name);