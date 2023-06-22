-- ユーザーテーブルデータ
INSERT INTO users(name, email,password) VALUES('田中', 'tanaka@a.com', 'himitu');


-- チャットテーブルデータ
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, 'はじめまして', 1, null);