DROP TABLE IF EXISTS oauth_client_details;
DROP TABLE IF EXISTS oauth_client_token;
DROP TABLE IF EXISTS oauth_access_token;
DROP TABLE IF EXISTS oauth_refresh_token;
DROP TABLE IF EXISTS oauth_code;
DROP TABLE IF EXISTS oauth_approvals;
DROP TABLE IF EXISTS ClientDetails;

CREATE TABLE oauth_client_details (
	client_id VARCHAR(255) NOT NULL PRIMARY KEY,
	client_secret VARCHAR(255),
	resource_ids VARCHAR(255),
	scope VARCHAR(255),
	authorized_grant_types VARCHAR(255),
	web_server_redirect_uri VARCHAR(255),
	authorities VARCHAR(255),
	access_token_validity INT(11),
	refresh_token_validity INT(11),
	additional_information VARCHAR(4096),
	autoapprove VARCHAR(255)
);

 INSERT INTO oauth_client_details (
	client_id,
	client_secret,
	resource_ids,
	scope,
	authorized_grant_types,
	web_server_redirect_uri,
	authorities,
	access_token_validity,
	refresh_token_validity,
	additional_information,
	autoapprove)
	VALUES(
    'USER_CLIENT_APP',
    '{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi',
	'USER_CLIENT_RESOURCE,USER_ADMIN_RESOURCE',
	'role_admin,role_user',
	'authorization_code,password,refresh_token,implicit',
	NULL,
	NULL,
	900,
	3600,
	'{}',
	NULL);
	
CREATE TABLE oauth_client_token (
	authentication_id VARCHAR(255) PRIMARY KEY,
	token_id VARCHAR(255),
	token VARCHAR(255),
	user_name VARCHAR(255),
	client_id VARCHAR(255)
);

CREATE TABLE oauth_access_token (
	authentication_id VARCHAR(255) PRIMARY KEY,
	token_id VARCHAR(255),
	token VARCHAR(255),
	user_name VARCHAR(255),
	client_id VARCHAR(255),
	authentication VARCHAR(255),
	refresh_token VARCHAR(255)
);

CREATE TABLE oauth_refresh_token (
    token_id VARCHAR(255),
    token VARCHAR(255),
    authentication VARCHAR(255)
);

CREATE TABLE oauth_code (
    code VARCHAR(255),
    authentication VARCHAR(255)
);

CREATE TABLE oauth_approvals (
    userId VARCHAR(255),
    clientId VARCHAR(255),
    scope VARCHAR(255),
    status VARCHAR(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);

CREATE TABLE ClientDetails (
    appId VARCHAR(255) PRIMARY KEY,
    resourceIds VARCHAR(255),
    appSecret VARCHAR(255),
    scope VARCHAR(255),
    grantTypes VARCHAR(255),
    redirectUrl VARCHAR(255),
    authorities VARCHAR(255),
    access_token_validity INT(30),
    refresh_token_validity INT(30),
    additionalInformation VARCHAR(4096),
    autoApproveScopes VARCHAR(255)
);
