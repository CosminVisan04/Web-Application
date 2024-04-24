FROM node:16 as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
FROM node:16
RUN npm install -g serve
WORKDIR /app
COPY --from=build /app/dist /app
EXPOSE 5173
CMD ["serve", "-s", "/app", "-l", "5173"]