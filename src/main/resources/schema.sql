-- テーブル削除
DROP TABLE IF EXISTS chats;

-- チャットテーブル
CREATE TABLE chats
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   text TEXT
);
