	var jsVendor = [
                'bower_components/jquery/dist/jquery.js',
				'bower_components/jquery-ui/jquery-ui.js',
				'bower_components/bootstrap/dist/js/bootstrap.min.js',
				'bower_components/angular/angular.js',
				'bower_components/angular-bootstrap/ui-bootstrap-tpls.min.js',
				'bower_components/d3/d3.js',
				//'bower_components/angular-aria/angular-aria.js',
				'bower_components/angular-ui-router/release/angular-ui-router.js',
				//'bower_components/angular-bootstrap/ui-bootstrap-tpls.js',
	];	
module.exports = function(grunt) {
	grunt.initConfig({
		pkg: grunt.file.readJSON('package.json'),
		sass: {
			build: {
				options: {
					style: 'expanded'
				},
				files: [{
					expand: true,
					cwd: 'src/main/webapp/sass/',
					src: ['**/*.scss'],
					dest: 'src/main/webapp/css/',
					ext: '.css'
				}]
			}
		},
		concat: {
		  vendor:{
				src : jsVendor,
                dest : 'src/main/webapp/js/vendor.js'
		  }
		},
		copy: {
		  main: {
			nonull: true,
			src: [
			'bower_components/jquery-ui/themes/base/jquery-ui.css',
			'bower_components/bootstrap/dist/fonts/**',
			'bower_components/bootstrap/dist/css/bootstrap.min.css',
			'bower_components/bootstrap-sass/assets/**'],
			dest: 'src/main/webapp/',
		  }
		},
		watch: {
			css: {
				files: 'src/main/webapp/**/*.scss',
				tasks: ['sass'],
				options: {
					interrupt: true,
					livereload: true
				}
			}
		},
		connect : {
			server : {
				options : {
					port : 9001,
					base : '.'
					//keepalive: true
					//livereload: true
				}
			}
		}
	});
	grunt.loadNpmTasks('grunt-contrib-sass');
	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.loadNpmTasks('grunt-contrib-watch');
	grunt.loadNpmTasks('grunt-contrib-connect');
	grunt.loadNpmTasks('grunt-contrib-copy');
	
	grunt.registerTask('build',['copy:main','sass','concat:vendor']);
	grunt.registerTask('default',['build']);
	grunt.registerTask('serve',['build','connect:server','watch']);
}