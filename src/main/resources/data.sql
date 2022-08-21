CREATE TABLE IF NOT EXISTS log (
    id      serial,
    message text,
    type    text,
    level   text,
    time    timestamp
);