const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const webpack = require('webpack');
const KotlinWebpackPlugin = require("@jetbrains/kotlin-webpack-plugin");
const sourceDirectory = 'src';
const packageDirectory = require('./package.json').kotlinPackage.replace(new RegExp('\\.', 'g'), '/');

module.exports = {
    context: __dirname,
    entry: {
        'vendor': `./${sourceDirectory}/vendor.js`,
        'kotlinApp': './kotlin_build/kotlinApp.js'
    },
    output: {
        path: __dirname + '/dist',
        filename: '[name].js'
    },
    resolve: {
        // We include 'kotlin_build" in modules because there will be compiled "kotlinApp.js" file
        modules: ['node_modules', 'kotlin_build'],
        alias: {
            _: path.resolve(__dirname, `./${sourceDirectory}/${packageDirectory}`)
        }
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                include: path.resolve(__dirname, '../kotlin_build'),
                use: ['@princed/source-map-loader'],
                enforce: 'pre',
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },
            {
                test: /\.css$/,
                use: [{loader: 'style-loader'}, {
                    loader: 'css-loader',
                    options: {sourceMap: true}
                }]
            },
            {
                test: /\.(png|jpe?g|gif|svg|woff|woff2|ttf|eot|ico)(\?.*$|$)/,
                loader: 'file-loader'
            },
            {
                test: /\.html$/,
                loader: 'raw-loader'
            }
        ]
    },

    plugins: [
        new HtmlWebpackPlugin({
            template: `./${sourceDirectory}/index.html`
        }),
        new webpack.ProvidePlugin({
            jQuery: 'jquery',
            $: 'jquery',
            Popper: 'popper.js'
        }),
        new KotlinWebpackPlugin({
            src: __dirname + `/${sourceDirectory}`
        })
    ],

    devtool: 'cheap-module-inline-source-map',

    devServer: {
        disableHostCheck: true,
        proxy: {
            '/generate': 'http://localhost:9000'
        }
    }
};
