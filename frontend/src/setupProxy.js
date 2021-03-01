// const { createProxyMiddleware } = require('http-proxy-middleware');
// //
// // const API_URL = process.env.API_URL;
// // if (API_URL == null) {
// //     throw new Error("Missing API_URL in environment file");
// // }
// //
// // module.exports = function(app) {
// //     app.use(createProxyMiddleware([
// //         "/oauth",
// //         "/api"
// //     ], {
// //         target: API_URL,
// //         secure: false,
// //         changeOrigin: true
// //     }));
// // };