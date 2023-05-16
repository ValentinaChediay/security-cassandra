// в cmd выполняю команду - cassandra => запускается cassandra

// при ПЕРВОМ запуске
// в первой cmd выполняю команду - cassandra => запускается cassandra
// в другой cmd выполняю команды:
// 1. cqlsh
// 2. describe keyspaces
// 3. create keyspace security WITH replication = {'class': 'SimpleStrategy', 'replication_factor':1};
// 4. describe keyspace security
// 5. use security;
// потом команды ниже

CREATE TABLE users (username text PRIMARY KEY,  password text, user_role text, first_name text, last_name text, email text, account_enabled BOOLEAN, account_expired BOOLEAN, account_locked BOOLEAN, credential_expired BOOLEAN);

INSERT INTO users(username, password, user_role, first_name, last_name, email, account_enabled, account_expired, account_locked, credential_expired) VALUES ('bob', '$2a$12$9nw6Rj2L0KPwNuioPEoAxe3u0jDBTkVOlS2HNSLgjkThWqId/GuqW', 'user', 'Bob', 'Doe', 'bob@doe.com', true, false, false, false);

INSERT INTO users(username, password, user_role, first_name, last_name, email, account_enabled, account_expired, account_locked, credential_expired) VALUES ('alice', '$2a$12$zIPiPmD2a/zMXzH9KeLGpef/KgRCtUXLdj6YBGowHUUyzQqGmzE7S', 'admin', 'Alice', 'Doe', 'alice@doe.com', true, false, false, false);

