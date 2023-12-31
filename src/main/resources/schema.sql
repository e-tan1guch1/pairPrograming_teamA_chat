-- テーブル削除
DROP TABLE IF EXISTS chats;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS todos;
DROP TABLE IF EXISTS friends;
DROP TABLE IF EXISTS requests;
DROP TABLE IF EXISTS icons;

-- チャットテーブル
CREATE TABLE chats
(
   id SERIAL PRIMARY KEY,
   user_id INTEGER,
   text TEXT,
   address_id INTEGER,
   date TIMESTAMP,
   like_button BOOLEAN DEFAULT false
);
-- ユーザーテーブル
CREATE TABLE users
(
   id SERIAL PRIMARY KEY,
   icon_id INTEGER DEFAULT 1,
   name TEXT,
   email TEXT,
   password TEXT
);

-- フレンドテーブル
CREATE TABLE friends
(
   id SERIAL PRIMARY KEY,
   user_id INTEGER,
   user2_id INTEGER
);

-- フレンドリクエストテーブル
CREATE TABLE requests
(
   id SERIAL PRIMARY KEY,
   reciever_id INTEGER,
   sender_id INTEGER
);

-- アイコンテーブル
CREATE TABLE icons
(
   id SERIAL PRIMARY KEY,
   icon_url TEXT
);

-- TODOテーブル
CREATE TABLE todos
(
   id SERIAL PRIMARY KEY,
   releaseDate TIMESTAMP,
   hour INTEGER,
   minute INTEGER,
   text TEXT,
    user_id INTEGER,
    checked BOOLEAN
);