/* global require process __dirname module */
const webpack = require('webpack')
const MiniCssExtractPlugin = require('mini-css-extract-plugin')
const path = require('path')

const env = process.env.NODE_ENV

module.exports = {
  mode: env || 'development',
  entry: {
	  common: ['./src/common.js', './src/common.scss'],
	  home: './src/home.js'
  },
  output: {
    filename: '[name].bundle.js',
    path: path.resolve(__dirname, 'public/build')
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader'
        }
      },
      {
        test: /\.sc|ass$/,
        use: [
          { loader: MiniCssExtractPlugin.loader },
          {
            loader: 'css-loader',
            options: {
              importLoaders: 1
            }
          },
          {
            loader: 'postcss-loader',
            options: {
              sourceMap: true,
              config: {
                ctx: {
                  cssnano: {},
                  autoprefixer: {}
                }
              }
            }
          },
          {
            loader: 'resolve-url-loader' // améliore la résolution des chemins relatifs
            // (utile par exemple quand une librairie tierce fait référence à des images ou des fonts situés dans son propre dossier)
          },
          {
            loader: 'sass-loader',
            options: {
              sourceMap: true // il est indispensable d'activer les sourcemaps pour que postcss fonctionne correctement
            }
          }
        ]
      },
      {
        test: /\.(eot|ttf|woff|woff2)$/,
        loader: 'file-loader',
        options: {
          name: 'fonts/[name].[hash].[ext]'
        }
      },
      {
        test: /\.(gif|png|jpe?g|svg)$/i,
        use: [
          'file-loader',
          { loader: 'image-webpack-loader' },
        ],
      },
    ]
  },
  plugins: [
    new MiniCssExtractPlugin({
      filename: '[name].bundle.css',
      chunkFilename: '[id].css'
    }),
    new webpack.ProvidePlugin({
    	$:'jquery',
    	jQuery: 'jquery'
    })
  ]
}