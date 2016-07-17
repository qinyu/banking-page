module.exports = {
  entry: './src/js/app.js',
  output: {
    filename: 'app.bundle.js'
  },
  devtool: 'cheap-module-source-map',
  module: {
    loaders: [{
      test: /\.js$/,
      exclude: /node_modules/,
      loader: 'babel-loader'
    }]
  }
};
